<template>
  <div>
    <h2>Member Login</h2>
    <form @submit.prevent="submit">
      <div>
        <label>ID</label>
        <input v-model="form.memberId" required />
      </div>
      <div>
        <label>Password</label>
        <input v-model="form.memberPw" type="password" required />
      </div>
      <button type="submit">Login</button>
    </form>
    <p v-if="token">Token: {{ token }}</p>
    <p v-if="error" style="color:red">{{ error }}</p>
  </div>
</template>

<script>
import http from '../api/http';

export default {
  name: 'LoginPage',
  data() {
    return {
      form: { memberId: '', memberPw: '' },
      token: '',
      error: '',
    };
  },
  methods: {
    async submit() {
      this.error = '';
      try {
        const { data } = await http.post('/login', this.form);
        this.token = data?.token || '';
        // localStorage.setItem('token', this.token);
      } catch (e) {
        this.error = e?.response?.data?.message || 'Login failed';
      }
    },
  },
};
</script>
