<template>
    <div id="app" class="main">
        <h2> {{ foundBook.title }} </h2>
        <h2> {{ foundBook.author }} </h2>
        <img v-if="foundBook.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + foundBook.isbn + '-M.jpg'" />
        <h3 v-if="foundBook.read"> I have read this book.</h3>
        <h3 v-if="!foundBook.read"> I have not read this book.</h3>
    </div>
</template>

<script>

export default {
    name: "book-details",
    computed: {
        foundBook() {
            return this.$store.state.books.find((book) => {
                return book.isbn == this.$route.params.isbn
            });
        }
    }
}
</script>

<style scoped></style>