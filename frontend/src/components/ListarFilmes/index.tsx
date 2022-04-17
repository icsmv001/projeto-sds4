import axios from "axios";

const ListarFilmes = axios.create({
  baseURL: "https://www.movieid.com/catalog/search?capitamarvel/",
});

export default ListarFilmes;
