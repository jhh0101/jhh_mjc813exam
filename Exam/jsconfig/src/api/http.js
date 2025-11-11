import axios from 'axios';

const http = axios.create({
  baseURL: 'http://localhost:8085',
  withCredentials: true,
});

http.interceptors.response.use(
  (res) => res,
  (err) => {
    console.error('[API ERROR]', err?.response || err);
    throw err;
  }
);

export default http;