import { Category, Products } from "./interfaces/models";

export class Data {
    all_products: Products[] = [
        {
            id: 1,
            name: "Earthen Bottle",
            url: "https://tailwindui.com/img/ecommerce-images/category-page-04-image-card-01.jpg",
            description: "",
            price: 48,
            quantity: 30,
            category: {
              id: 1,
              name: "Bottle"
            },
            createdDate: "12-07-24",
            soldDate: "20-07-24"
          },
          {
            id: 2,
            name: "Nomad Tumbler",
            url: "https://tailwindui.com/img/ecommerce-images/category-page-04-image-card-02.jpg",
            description: "",
            price: 35,
            quantity: 30,
            category: {
              id: 1,
              name: "Bottle"
            },
            createdDate: "12-07-24",
            soldDate: "19-07-24"
          }
    ]

    all_categories: Category[] = [
        {id: 1, name: "Bottle", imageUrl: ""},
        {id: 1, name: "Bottle", imageUrl: ""}
      ]

}
