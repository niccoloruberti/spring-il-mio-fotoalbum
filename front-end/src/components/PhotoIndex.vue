<template>

    <ul>
        <li 
            class="list-unstyled"
            v-for="photo in photos" 
            :key="photo.id"
        >
            {{ photo.name }}
        </li>
    </ul>

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