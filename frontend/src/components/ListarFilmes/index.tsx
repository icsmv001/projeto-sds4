import axios from "axios";

const ListarFilmes = axios.create({
  baseURL: "https://www.telecine.com.br/search?term=matris",
});

export default ListarFilmes;
