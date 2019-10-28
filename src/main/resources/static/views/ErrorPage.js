
export const ErrorPage = {
    render: async() => {
        const html = 
        `
            <h1>404 Page not found!</h1>
        `
        return html;
    },
    postRender: async() => {
       console.log("Page is now in Error");
    }
}