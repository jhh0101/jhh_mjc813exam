<template>
  <div>
    <h2>Write Board</h2>
    <form @submit.prevent="submit">
      <div>
        <label>Title</label>
        <input v-model="form.btitle" required />
      </div>
      <div>
        <label>Author</label>
        <input v-model="form.bwriter" required />
      </div>
      <div>
        <label>Content (HTML allowed)</label>
        <textarea v-model="form.bcontent" rows="8" style="width:100%;"></textarea>
      </div>
      <button type="submit">Publish</button>
    </form>
    <p v-if="message" style="color:green">{{ message }}</p>
    <p v-if="error" style="color:red">{{ error }}</p>
  </div>
</template>

<script>
import http from '../api/http';

export default {
  name: 'BoardWrite',
  data() {
    return {
      form: { btitle: '', bcontent: '', bwriter: '' },
      message: '',
      error: '',
    };
  },
  methods: {
    async submit() {
      this.message = ''; this.error = '';
      try {
        await http.post('/write', this.form);
        this.message = 'Posted!';
        this.$router.push('/board');
      } catch (e) {
        this.error = e?.response?.data?.message || 'Failed to post';
      }
    },
  },
};
</script>
