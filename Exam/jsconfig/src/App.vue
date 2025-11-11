<template>
  <div>
    <nav style="display:flex; gap:12px; padding:12px; border-bottom:1px solid #ddd;">
      <RouterLink to="/join">Join</RouterLink>
      <RouterLink to="/login">Login</RouterLink>
      <RouterLink to="/board">Board List</RouterLink>
      <RouterLink to="/board/write">Write Board</RouterLink>
    </nav>
    <main style="padding:16px;">
      <RouterView />
    </main>
  </div>
</template>

<script>
export default { name: 'App' };
</script>
