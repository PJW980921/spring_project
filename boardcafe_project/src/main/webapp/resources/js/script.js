const container = document.getElementsByClassName("main-container");
const menuAdmin = document.getElementsByClassName("menu-admin");
const menuList = document.getElementsByClassName("menu-list");
 

const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute('content');
const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute('content');