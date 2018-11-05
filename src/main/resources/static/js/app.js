//fetch(`/api/reviews/${window.location.pathname.split('/')[2]}`, {
//	method: 'get'
//})
//	.then(res => res.json())
//	.then(data => {
//		console.log(data)
//		const tags = document.querySelector('.tags')
//		const tagLinks = `<a href="/tags/${data.tags.id}">${data.tags.tagName}</a>`
//		
//		tags.innerHTML = tagLinks
//	})
	const input = document.querySelector('#tagInput')
const addTagButton = document.querySelector('button')

addTagButton.addEventListener('click', () => {
  fetch(`../api/reviews/16/${window.location.pathname.split('/')[2]}```,{
    method:'post',
    body: JSON.stringify({
      tagName: input.value,
    }),
  })
    .then(res => res.json())
    .then(data => console.log)
})