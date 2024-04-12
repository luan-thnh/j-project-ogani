/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

const headerBottom = document.querySelector('.header-bottom')

window.onscroll = () => {
  headerBottom.classList.toggle('sticky', window.scrollY > 47);
};