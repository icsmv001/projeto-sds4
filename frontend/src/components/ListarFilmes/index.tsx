import axios from "axios";

// versao 2022/06/226 - com dados mocados para listar filmes

const ListarFilmes = axios.create({
  baseURL: "https://www.movieid.com/catalog/search?capitamarvel/",
});

export default ListarFilmes;
