<template>
  <div>
    <!--header-->
    <nav class="w-100 fixed-top bg-dark">
        <span class="mb-0 h1 text-white"
        @click="isContacting = false"
        >Album Fotografico</span>
    </nav>

    <div
    v-if="!isContacting">
      <div class="d-flex col-6 offset-3 my-5" role="search">
        <input
          class="form-control me-2"
          type="search"
          v-model="searchStr"
          placeholder="Cerca una foto..."
        />
        <button 
        class="btn btn-outline-success"
        @click="search">Cerca</button>
      </div>
    </div>

    <!-- photo index -->
    <PhotoIndex
    v-if="!isContacting"
    :photos="(isFiltered ? filteredPhotos : photos)"
    />

    <!-- contattaci -->
    <a
    v-if="!isContacting"
    @click="isContacting = true"
     class="mt-5 btn btn-outline-success">Contattaci</a>

    <!-- form -->
    <form
    @submit.prevent="sendMessage"
    v-if="isContacting">
      <label class="form-label" for="name">Nome</label>
      <input class="form-control" type="text" name="name" id="name" v-model="contact.name">
      <label class="form-label" for="email">Email</label>
      <input class="form-control" type="email" id="email" name="email" v-model="contact.email">
      <label class="form-label" for="message">Messaggio</label>
      <input class="form-control" type="text" id="message" name="message" v-model="contact.message">
      <button
      class="mt-3 btn btn-success"
      type="submit">Invia</button>
    </form>
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
  let isContacting = ref(false);
  const contact = ref({
    name: '',
    email: '',
    message: ''
  });

  //functions

  const getPhotos = async () => {
    const data = await axios.get("http://localhost:8080/api/photos");
    photos.value = data.data;

    console.log(data);
  };

  const sendMessage = async () => {
    const response = await axios.post('http://localhost:8080/api/contact', contact.value);
    console.log(response);
    isContacting.value = false;
};

  const search = () => {
    if(searchStr.value !== null) {
      filteredPhotos.value = photos.value.filter((photo) => photo.name.toLowerCase().includes(searchStr.value.toLowerCase()));
      isFiltered.value = true;
      console.log(filteredPhotos)
    } else {
      getPhotos();
    }
  }

//hooks
onMounted(getPhotos);

</script>

<style scoped>

</style>
