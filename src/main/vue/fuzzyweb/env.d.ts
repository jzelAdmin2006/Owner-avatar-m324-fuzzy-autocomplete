/// <reference types="vite/client" />
interface ImportMetaEnv {
  readonly VITE_BACKEND_API_URL: string;
  // Add more variables as needed
}

interface ImportMeta {
  readonly env: ImportMetaEnv;
}
