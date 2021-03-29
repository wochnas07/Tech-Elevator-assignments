<template>
<!-- generate one div for each element in the filteredReviews array -->
  <div class="reviews">
    <review-display
      v-for="review in filteredReviews"
      v-bind:key="review.title"
      v-bind:review="review"
    />
  </div>
</template>

<script>
import ReviewDisplay from "./ReviewDisplay";

export default {
  name: "review-list",
  components: {
    ReviewDisplay
  },
  computed: {
    filteredReviews() {
      // this value will be used to filter the reviews
      const reviewsFilter = this.$store.state.filter
      
      //copy the reviews array from the data store into this component so we can use it
      const reviews = this.$store.state.reviews
      // .filter(0) - return an array of element where the anon-function returned true for the element it was sent
      return reviews.filter(review => {
        // determine if the current element rating in the reviews array matches the reviewsFilter value
        // return true if the reviewsFilter value is 0 or the rating in the element == reviewsFilter value
        return reviewsFilter === 0 ? true : reviewsFilter === review.rating;
      });
    }
  }
};
</script>

<style>
div.main {
  margin: 1rem 0;
}
div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.well-display div.well {
  cursor: pointer;
}
</style>
