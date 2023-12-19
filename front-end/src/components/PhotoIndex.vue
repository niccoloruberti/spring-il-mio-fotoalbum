<template>
    <div class="container">
        <div class="row">
            <div
            class="list-unstyled col-4 my-3"
            v-for="photo in photos" 
            :key="photo.id">
                <div class="card h-100">
                <img :src="photo.url" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">{{ photo.name }}</h5>
                    <p class="card-text">{{ photo.description }}</p>
                </div>
                </div>
            </div>
        </div>
    </div>

</template>

<script setup>

//import libraries
import { defineProps } from 'vue';

// props
const props = defineProps({
    photos: {
        type: Array,
        required: true
    }
});

</script>

<style scoped>
    
</style>