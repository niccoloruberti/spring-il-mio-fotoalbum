<template>
  <div>
    <div>
      <input
        type="text"
        v-model="searchStr"
        placeholder="Cerca una foto..."
      />
      <button @click="search">Cerca</button>
    </div>

    <!-- photo index -->
    <PhotoIndex
    :photos="(isFiltered ? filteredPhotos : photos)"
    />
  </div>

</template>

<script setup>

  //import libraries
  import axios from 'axios';
  import { ref, onMounted } from 'vue';
  
  //import components
  import PhotoIndex from './components/PhotoIndex.vue';

  //data

  const photos = ref(null);
  let filteredPhotos = ref(null);
  let searchStr = ref(null);
  let isFiltered = ref(false);

  //functions

  const getPhotos = async () => {
    const data = await axios.get("http://localhost:8080/api/photos");
    photos.value = data.data;

    console.log(data);
  };

  const search = () => {
    if(searchStr.value !== null) {
      filteredPhotos.value = photos.value.filter((photo) => photo.name.toLowerCase().includes(searchStr.value.toLowerCase()));
      isFiltered.value = true;
    } else {
      getPhotos();
    }
  }

//hooks
onMounted(getPhotos);

</script>

<style scoped>

</style>
