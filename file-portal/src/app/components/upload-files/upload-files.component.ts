import {Component, OnInit} from '@angular/core';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FileUploadService} from 'src/app/services/file-upload.service';
import {MatTableDataSource} from "@angular/material/table";

export interface FileElement {
  id: number;
  name: string;
  status: string;
}

@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.css']
})
export class UploadFilesComponent implements OnInit {
  selectedFiles?: FileList;
  uploadProgress: boolean = false;
  progressInfos: any[] = [];
  message: string[] = [];
  displayedColumns: string[] = ['id', 'name', 'status'];
  fileInfos?: Observable<any>;
  dataSource = new MatTableDataSource<FileElement>([]);

  constructor(private uploadService: FileUploadService) {
  }
  ngOnInit(): void {
    this.uploadProgress = false;
    this.fileInfos = this.uploadService.getFiles();
    this.getAllFiles();
  }

  private delay(ms: number)
  {
    return new Promise(resolve => setTimeout(resolve, ms));
  }
  getAllFiles() {
    this.uploadService.getFiles().subscribe((data: any) => {
      this.dataSource = new MatTableDataSource<FileElement>(data);
      return data
    });
  }
  selectFiles(event: any): void {
    this.message = [];
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
  }

  async upload(idx: number, file: File): Promise<void> {
    this.uploadProgress = true;
   // await this.delay(7000);
    this.progressInfos[idx] = {value: 0, fileName: file.name};

    if (file) {
      this.uploadService.upload(file).subscribe({
        next: (event: any) => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progressInfos[idx].value = Math.round(100 * event.loaded / event.total);
          } else if (event instanceof HttpResponse) {
            const msg = file.name + ": Successful!";
            this.message.push(msg);
            this.fileInfos = this.uploadService.getFiles();
            this.uploadProgress = false;
            this.getAllFiles();
          }
        },
        error: (err: any) => {
          this.progressInfos[idx].value = 0;
          let msg = file.name + ": Failed!";

          if (err.error && err.error.message) {
            msg += " " + err.error.message;
          }
          this.message.push(msg);
          this.fileInfos = this.uploadService.getFiles();
          this.uploadProgress = false;
          this.getAllFiles();
        }
      });
    }
  }

  uploadFiles(): void {
    this.message = [];
    if (this.selectedFiles) {
      for (let i = 0; i < this.selectedFiles.length; i++) {
        this.upload(i, this.selectedFiles[i]);
      }
    }
  }

}
