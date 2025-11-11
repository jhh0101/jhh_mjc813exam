<template>
  <div>
    <h2>Member Join</h2>
    <form @submit.prevent="submit">
      <div>
        <label>ID</label>
        <input v-model="form.memberId" required />
      </div>
      <div>
        <label>Password</label>
        <input v-model="form.memberPw" type="password" required />
      </div>
      <div>
        <label>Nickname</label>
        <input v-model="form.memberName" />
      </div>
      <button type="submit">Join</button>
    </form>
    <p v-if="message" style="color:green">{{ message }}</p>
    <p v-if="error" style="color:red">{{ error }}</p>
  </div>
</template>

<script>
import http from '../api/http';

export default {
  name: 'JoinPage',
  data() {
    return {
      form: { memberId: '', memberPw: '', memberName: '' },
      message: '',
      error: '',
    };
  },
  methods: {
    async submit() {
      this.message = ''; this.error = '';
      try {
        await http.post('/join', this.form);
        this.message = 'Joined successfully!';
      } catch (e) {
        this.error = e?.response?.data?.message || 'Join failed';
      }
    },
  },
};
</script>
