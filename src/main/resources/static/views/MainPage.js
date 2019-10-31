
export const MainPage = {
    render: async() => {
        const html = 
        `
            <h3>MainPage</h3>
        `
        return html;
    },
    postRender: async() => {
       console.log("Page is now in MainPage");
    }
}