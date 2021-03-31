<template>
    <div id="app" class="main">
        <h2> {{ foundBook.title }} </h2>
        <h2> {{ foundBook.author }} </h2>
        <img v-if="foundBook.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + foundBook.isbn + '-M.jpg'" />
        <p> I have read this book </p>

    </div>
</template>

<script>

export default {
    name: "isbn-search",
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