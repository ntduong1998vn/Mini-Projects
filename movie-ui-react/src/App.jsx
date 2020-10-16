import React, { useEffect, useState } from "react";
import "./App.css";
import Movie from "./components/Movie";

function App() {
  const [movies, setMovies] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  useEffect(() => {
    getMovies(process.env.REACT_APP_FEATURE);
  }, []);

  function getMovies(API) {
    fetch(API)
      .then((res) => res.json())
      .then((data) => {
        setMovies(data.results);
      });
  }

  function handleSubmit(e) {
    e.preventDefault();
    if (searchTerm !== "") {
      getMovies(process.env.REACT_APP_SEARCH + searchTerm);
    }
  }

  function handleChange(e) {
    setSearchTerm(e.target.value);
  }

  return (
    <div className="wrapper">
      <header>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            className="search"
            placeholder="Search"
            value={searchTerm}
            onChange={handleChange}
          />
        </form>
      </header>

      <div className="movie-container">
        {movies.length > 0
          ? movies.map((item, index) => (
              <Movie
                key={index}
                title={item.title}
                poster_path={item.poster_path}
                vote_average={item.vote_average}
                overview={item.overview}
              />
            ))
          : null}
      </div>
    </div>
  );
}

export default App;
