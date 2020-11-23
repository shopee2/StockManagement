<template>
  <div id="app">
    <b-container>
      <b-jumbotron
        header="Stock Management"
        lead="Dashboard for managing stock"
      >
        <b-button
          @click="currentSection = 'category'"
          variant="primary"
          class="mr-1"
        >
          Category
        </b-button>

        <b-button @click="currentSection = 'product'" variant="primary">
          Product
        </b-button>
      </b-jumbotron>

      <CategorySection v-if="currentSection === 'category'" />

      <ProductSection
        v-else-if="currentSection === 'product'"
        :catFilter="productCatFilter"
      />

      <template v-else>
        <div class="text-muted text-center">
          Select either category or product to manage
        </div>
      </template>
    </b-container>
  </div>
</template>

<script>
import CategorySection from "./components/CategorySection.vue";
import ProductSection from "./components/ProductSection.vue";

export default {
  components: { CategorySection, ProductSection },
  name: "App",
  data() {
    return {
      currentSection: undefined,
      productCatFilter: undefined,
    };
  },
  created() {
    const uri = window.location.search.substring(1);
    const params = new URLSearchParams(uri);
    const section = params.get("section");
    if (section) this.currentSection = section;

    const catFilter = params.get("catfilter");
    if (catFilter) this.productCatFilter = catFilter;
  },
};
</script>

<style lang="scss"></style>
