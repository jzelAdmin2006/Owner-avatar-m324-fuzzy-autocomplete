<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header class="mb-36">
    <nav class="flex items-center justify-between flex-wrap bg-teal p-6 bg-blue-300">
      <div class="w-full block flex-grow lg:flex lg:items-center lg:w-auto">
        <div class="text-sm lg:flex-grow">
          <RouterLink class="block text-3xl text-white hover:text-black mr-4" to="/">
            Fuzzysearch
          </RouterLink>
        </div>
      </div>
    </nav>
  </header>

  <RouterView />
</template>
