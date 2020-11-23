<template>
  <div>
    <h3>
      Manage categories
      <b-button
        variant="success"
        v-b-modal.modal-new
        @click="
          () => {
            modalMode = 'add';
          }
        "
      >
        <i class="fa fa-plus"></i> Add New
      </b-button>
    </h3>
    <hr />
    <b-table-lite :fields="categoryFields" :items="categories">
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
          class="mr-1"
          @click="
            () => {
              deleteCat(data.item.id);
            }
          "
        >
          <i class="fa fa-trash"></i>
        </b-button>
        <b-button
          variant="primary"
          @click="
            () => {
              goFilterCat(data.item.id);
            }
          "
        >
          <i class="fa fa-chevron-right"></i>
        </b-button>
      </template>
    </b-table-lite>

    <b-modal id="modal-new" :title="`${modalMode} Category`" @ok="okHandle">
      <b-form-group label="id" label-for="id">
        <b-input id="id" type="number" v-model="modalData.id"></b-input>
      </b-form-group>
      <b-form-group label="name" label-for="name">
        <b-input id="name" v-model="modalData.name"></b-input>
      </b-form-group>
      <b-form-group label="description" label-for="description">
        <b-input id="description" v-model="modalData.description"></b-input>
      </b-form-group>
    </b-modal>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      categoryFields: ["id", "name", "description", "actions"],
      categories: [],
      modalData: {
        id: undefined,
        name: "",
        description: "",
      },
      modalMode: undefined,
    };
  },
  methods: {
    async fetchData() {
      const { data: categoryData } = await axios.get("/category");
      this.categories = categoryData;
    },
    refreshWithParams() {
      const url = new URL(window.location.href);
      url.searchParams.set("section", "category");
      window.location.replace(url);
    },
    async okHandle() {
      switch (this.modalMode) {
        case "add":
          await axios.post("/category", this.modalData);
          break;
        case "edit":
          await axios.put(`/category/${this.modalData.id}`, this.modalData);
          break;
      }
      this.refreshWithParams();
    },
    async deleteCat(id) {
      await fetch(`/category/${id}`, {
        method: "delete",
      });
      this.refreshWithParams();
    },
    async editCat(id) {
      const { data } = await axios.get(`/category/${id}`);
      this.modalData = data;
    },
    goFilterCat(id) {
      const url = new URL(window.location.href);
      url.searchParams.set("section", "product");
      url.searchParams.set("catfilter", id);
      window.location.replace(url);
    },
  },
  created() {
    this.fetchData();
  },
};
</script>

<style></style>
