const currentPage = window.location.pathname.split('/').pop()

export const setupMenu = () => {
	document.querySelectorAll('.menu-item').forEach(item => {
		const link = item.getAttribute('href')

		if (link === currentPage) {
			item.classList.add('active')
		} else {
			item.classList.remove('active')
		}
	})
}
