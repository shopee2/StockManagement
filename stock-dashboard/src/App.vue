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
          >Category</b-button
        >
        <b-button @click="currentSection = 'product'" variant="primary"
          >Product</b-button
        >
      </b-jumbotron>

      <template v-if="currentSection === 'category'">
        <h3>Managing categories</h3>
        <hr />
        <b-table-lite :fields="categoryFields" :items="categories">
          <template #cell(actions)="data">
            <b-button variant="danger">DELETE</b-button>
          </template>
        </b-table-lite>
      </template>

      <template v-else-if="currentSection === 'product'">
        <h3>Managing products</h3>
        <hr />
        <b-table-lite :fields="productFields" :items="products">
          <template #cell(actions)="data">
            <b-button variant="danger">DELETE</b-button>
          </template>
        </b-table-lite>
      </template>

      <template v-else>
        <div class="text-muted text-center">
          Select either category or product to manage
        </div>
      </template>
    </b-container>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      currentSection: undefined,
      categoryFields: ["id", "name", "description", "actions"],
      categories: [{ id: 12, name: "rasas", description: "231" }],
      productFields: [
        "id",
        "sku",
        "name",
        "description",
        "imageUrl",
        "weight",
        "price",
        "stock",
        "shopId",
        "categoryId",
        "actions",
      ],
      products: [
        {
          id: 1,
          sku: "sarssa",
          name: "arsw",
          description: "arsras",
          imageUrl: "arsar",
          weight: 1234,
          price: 1112,
          stock: 8,
          shopId: 4,
          categoryId: 2,
        },
      ],
    };
  },
};
</script>

<style lang="scss"></style>
