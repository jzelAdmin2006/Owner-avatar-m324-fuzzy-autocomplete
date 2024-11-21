<template>
  <div>
    <input type="file" @change="handleFileChange" />
    <button class="btn btn-blue" @click="uploadFile" :disabled="!selectedFile">Upload</button>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import axios from "axios";

// Reactive variable to hold the selected file
const selectedFile = ref(null);

// Function to handle file selection
const handleFileChange = (event : any) => {
  selectedFile.value = event.target.files[0];
};

// Function to upload the selected file
const uploadFile = async () => {
  if (!selectedFile.value) return;

  // Create a FormData object
  const formData = new FormData();
  formData.append("file", selectedFile.value);

  try {
    const response = await axios.post("http://localhost:8080/upload", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });
    console.log("Upload successful:", response.data);
  } catch (error) {
    console.error("Error uploading file:", error);
  }
};
</script>

<style>
button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
</style>
