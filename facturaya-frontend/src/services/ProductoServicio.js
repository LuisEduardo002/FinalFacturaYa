import axios from "axios";

const REST_API_BASE_URL = "http://127.0.0.1:8080/api/productos";

export const listProductos = () =>{
    return axios.get(REST_API_BASE_URL);
}

