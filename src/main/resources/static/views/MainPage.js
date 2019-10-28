
export const MainPage = {
    render: async() => {
        const html = 
        `
            <h1>Main Page</h1>
        `
        return html;
    },
    postRender: async() => {
       console.log("Page is now in MainPage");
    }
}