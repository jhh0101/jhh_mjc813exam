<template>
  <div>
    <h2>Board Detail (ID: {{ id }})</h2>

    <div style="margin:8px 0;">
      <label>
        <input type="checkbox" v-model="safeMode" />
        Use Safe Mode (sanitize with DOMPurify)
      </label>
    </div>

    <div v-if="post">
      <p><strong>Title:</strong> {{ post.btitle }}</p>
      <p><strong>Author:</strong> {{ post.bwriter }}</p>

      <div style="margin-top:12px; padding:12px; border:1px dashed #aaa;">
        <p><strong>Rendered Content:</strong></p>

        <div v-if="!safeMode" v-html="post.bcontent"></div>
        <div v-else v-html="sanitizedHtml"></div>
        
      </div>

      <div style="margin-top:16px;">
        <RouterLink to="/board">← Back to list</RouterLink>
      </div>
    </div>

    <p v-if="error" style="color:red">{{ error }}</p>
  </div>
</template>

<script>
import http from '../api/http';
import DOMPurify from 'dompurify';

export default {
  name: 'BoardDetail',
  props: ['id'],
  data() {
    return {
      post: null,
      error: '',
      safeMode: false,
    };
  },
  computed: {
    sanitizedHtml() {
      return this.post?.bcontent ? DOMPurify.sanitize(this.post.bcontent, { USE_PROFILES: { html: true } }) : '';
    },
  },
  async mounted() {
    await this.fetchDetail();
  },
  methods: {
    async fetchDetail() {
      this.error = '';
      try {
        const { data } = await http.get(`/detail/${~~this.id}`);
        this.post = data;
      } catch (e) {
        this.error = e?.response?.data?.message || 'Failed to load detail';
      }
    },
  },
};
</script>
