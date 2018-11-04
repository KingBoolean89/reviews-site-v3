fetch(`/api/reviews/${window.location.pathname.split('/')[2]}`, {
	method: 'get'
})
	.then(res => res.json())
	.then(data => {
		console.log(data)
		const tags = document.querySelector('.tags')
		const tagLinks = `<a href="/tags/${data.tags.id}">${data.tags.tagName}</a>`
		
		tags.innerHTML = tagLinks
	})