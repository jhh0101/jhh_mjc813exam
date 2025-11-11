<template>
  <div>
    <h2>Board List</h2>
    <table border="1" cellpadding="6" cellspacing="0">
      <thead>
        <tr><th>ID</th><th>Title</th><th>Author</th></tr>
      </thead>
      <tbody>
        <tr v-for="post in list" :key="post.id">
          <td>{{ post.bid }}</td>
          <td><RouterLink :to="`/board/${post.bid}`">{{ post.btitle }}</RouterLink></td>
          <td>{{ post.bwriter }}</td>
        </tr>
      </tbody>
    </table>
    <p v-if="error" style="color:red">{{ error }}</p>

    <div style="margin-top:16px;">
      <RouterLink to="/board/write">➕ Write a new post</RouterLink>
    </div>
  </div>
</template>

<script>
import http from '../api/http';

export default {
  name: 'BoardList',
  data() {
    return {
      list: [],
      error: '',
    };
  },
  async mounted() {
    await this.fetchList();
  },
  methods: {
    async fetchList() {
      this.error = '';
      try {
        const { data } = await http.get('/list');
        this.list = data || [];
      } catch (e) {
        this.error = e?.response?.data?.message || 'Failed to load list';
      }
    },
  },
};
</script>
