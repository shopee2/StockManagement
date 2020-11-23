<template>
  <div>
    <h3>
      Manage products
      <b-button variant="success"><i class="fa fa-plus"></i> Add New</b-button>
    </h3>
    <hr />
    <b-table-lite :fields="productFields" :items="products">
      <template #cell(actions)="data">
        <b-button variant="success" class="mr-1">
          <i class="fa fa-pencil"> </i>
        </b-button>
        <b-button variant="danger"><i class="fa fa-trash"></i></b-button>
      </template>
    </b-table-lite>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
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
      products: [],
    };
  },
  async created() {
    const { data: productData } = await axios.get("http://localhost/product");
    this.products = productData;
  },
};
</script>

<style></style>
