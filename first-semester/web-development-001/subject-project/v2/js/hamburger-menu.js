const button = document.getElementById('menu-button')
const menu = document.getElementById('mobile-menu')

button.addEventListener('click', () => {
    menu.classList.toggle('show')

    const isOpen = menu.classList.contains('show')

    button.setAttribute('aria-expanded', !isOpen)
})
