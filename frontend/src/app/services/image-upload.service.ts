import { Injectable, inject } from '@angular/core';
import { Storage, ref, uploadBytes, getDownloadURL } from '@angular/fire/storage';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageUploadService {
  private storage = inject(Storage);

  uploadImage(file: File): Promise<string> {
    const filePath = `recipes/${file.name}`;
    const storageRef = ref(this.storage, filePath);

    return uploadBytes(storageRef, file).then(() =>
      getDownloadURL(storageRef)
    );
  }
}
