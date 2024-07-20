export interface Login {
  email: String;
  password: String;
}

export interface Products {
  id: Number;
  name: String;
  image: String;
  description: String;
  price: Number;
  quantity: Number;
  category: Category;
  createdDate: String;
  soldDate: String;
}

export interface Category {
  id: Number;
  name: String;
  image?: String;
}
