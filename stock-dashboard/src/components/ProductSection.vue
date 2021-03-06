<template>
  <div>
    <h3>
      Manage products
      <b-button
        variant="success"
        v-b-modal.modal-new
        @click="
          () => {
            modalMode = 'add';
          }
        "
        ><i class="fa fa-plus"></i> Add New</b-button
      >
    </h3>
    <hr />
    <b-table-lite :fields="productFields" :items="products">
      <template #cell(categoryId)="data">
        {{ getCatName(data.item.categoryId) }}
      </template>
      <template #cell(shopId)="data">
        {{ getShopName(data.item.shopId) }}
      </template>
      <template #cell(actions)="data">
        <b-button
          variant="success"
          class="mr-1"
          v-b-modal.modal-new
          @click="
            () => {
              editCat(data.item.id);
              modalMode = 'edit';
            }
          "
        >
          <i class="fa fa-pencil"> </i>
        </b-button>
        <b-button
          variant="danger"
          @click="
            () => {
              deleteCat(data.item.id);
            }
          "
          ><i class="fa fa-trash"></i
        ></b-button>
      </template>
    </b-table-lite>

    <b-modal id="modal-new" :title="`${modalMode} Category`" @ok="okHandle">
      <b-form-group label="id" label-for="id">
        <b-input id="id" v-model="modalData.id"></b-input>
      </b-form-group>
      <b-form-group label="sku" label-for="sku">
        <b-input id="sku" v-model="modalData.sku"></b-input>
      </b-form-group>
      <b-form-group label="name" label-for="name">
        <b-input id="name" v-model="modalData.name"></b-input>
      </b-form-group>
      <b-form-group label="description" label-for="description">
        <b-input id="description" v-model="modalData.description"></b-input>
      </b-form-group>
      <b-form-group label="imageUrl" label-for="imageUrl">
        <b-input id="imageUrl" v-model="modalData.imageUrl"></b-input>
      </b-form-group>
      <b-form-group label="weight" label-for="weight">
        <b-input id="weight" v-model="modalData.weight"></b-input>
      </b-form-group>
      <b-form-group label="price" label-for="price">
        <b-input id="price" v-model="modalData.price"></b-input>
      </b-form-group>
      <b-form-group label="stock" label-for="stock">
        <b-input id="stock" v-model="modalData.stock"></b-input>
      </b-form-group>
      <b-form-group label="shopId" label-for="shopId">
        <b-input id="shopId" v-model="modalData.shopId"></b-input>
      </b-form-group>
      <b-form-group label="categoryId" label-for="categoryId">
        <b-input id="categoryId" v-model="modalData.categoryId"></b-input>
      </b-form-group>
    </b-modal>
  </div>
</template>

<script>
import axios from "axios";

export default {
  props: ["catFilter"],
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
        { key: "categoryId", label: "Category" },
        "actions",
      ],
      products: [],
      categories: [],
      shops: [],
      modalData: {
        id: undefined,
        sku: "",
        name: "",
        description: "",
        imageUrl: "",
        weight: undefined,
        price: undefined,
        stock: undefined,
        shopId: undefined,
        categoryId: undefined,
      },
      modalMode: undefined,
    };
  },
  methods: {
    async fetchData() {
      const { data: productData } = await axios.get("/product");

      if (this.catFilter) {
        this.products = productData.filter(
          (item) => item.categoryId == this.catFilter
        );
      } else {
        this.products = productData;
      }

      const { data: categoryData } = await axios.get("/category");

      this.categories = categoryData;

      const { data: shopData } = await axios.get(
        "https://sop-sale.azurewebsites.net/api/shop"
      );
      this.shops = shopData;
    },
    refreshWithParams() {
      const url = new URL(window.location.href);
      url.searchParams.set("section", "product");
      window.location.replace(url);
    },
    async okHandle() {
      switch (this.modalMode) {
        case "add":
          await axios.post("/product", this.modalData);
          break;
        case "edit":
          await axios.put(`/product/${this.modalData.id}`, this.modalData);
          break;
      }
      this.refreshWithParams();
    },
    async deleteCat(id) {
      await fetch(`/product/${id}`, {
        method: "delete",
      });
      this.refreshWithParams();
    },
    async editCat(id) {
      const { data } = await axios.get(`/product/${id}`);
      this.modalData = data;
    },
    getCatName(id) {
      const result = this.categories.find((item) => item.id === id);
      return result.name;
    },
    getShopName(id) {
      const result = this.shops.find((item) => item.id === id);
      return result.name;
    },
  },
  created() {
    this.fetchData();
  },
};
</script>

<style></style>
