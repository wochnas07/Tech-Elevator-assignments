// A skeleton of this file is automatically generated when you select Vuex as an option on vue create

import Vue from 'vue'     // Include the Vue support code
import Vuex from 'vuex'   // Include the Vuex support code

Vue.use(Vuex)             // I want to use Vuex to manage my shared data

export default new Vuex.Store({   // export exposes this data to processes outside the file
                                  //    and create a new Vuex data store
  state: {                // attribute to hold any data stored in the data store
    name: 'Cigar Parties for Dummies',
    description: 'Host and plan the perfect cigar party for all of your squirrelly friends.',
    filter: 0,            // control which array elements are displayed
    reviews: [
      {
        reviewer: 'Malcolm Gladwell',
        title: 'What a book!',
        review:
          "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
        rating: 3,
        favorited: false
      },
      {
        reviewer: 'Tim Ferriss',
        title: 'Had a cigar party started in less than 4 hours.',
        review:
          "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
        rating: 4,
        favorited: false
      },
      {
        reviewer: 'Ramit Sethi',
        title: 'What every new entrepreneurs needs. A door stop.',
        review:
          "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
        rating: 1,
        favorited: false
      },
      {
        reviewer: 'Gary Vaynerchuk',
        title: 'And I thought I could write',
        review:
          "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
        rating: 3,
        favorited: false
      }
    ],
  },    // end of the state attribute
  mutations: {            // methods to change data in the data store - called by components
                          // Mutations names:   all UPPERCASE with _ between the words

    ADD_REVIEW(state, review) {         // Add a review to our data array - receives state and the new review
      state.reviews.unshift(review);    // Take the new review passed and add it to the start of the array
    },
    UPDATE_FILTER(state, filter) {      // Set the filter value used to filter the elements displayed
      state.filter = filter;
    },
    FLIP_FAVORITED(state, reviewToChange) { // Toggle the favorited attribute (boolean)
      reviewToChange.favorited = ! reviewToChange.favorited;
    }
  },  // end of mutations
  actions: {
  },
  modules: {
  },
  strict: true          // strict attribute tells Vue whether to limit changes to any data in the data store
                        //      to mutations
                        //      true - Only changes made through mutations are allowed
                        //              Stop components from making changes directly to data in the data store
                        //      false - allow components to directly change (violate Single Responsibility rule)
})
