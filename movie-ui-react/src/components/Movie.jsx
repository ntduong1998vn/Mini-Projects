import React from "react";

const IMG_API = process.env.REACT_APP_IMAGE;

export default function Movie({ title, poster_path, overview, vote_average }) {
  function setVoteClass(vote) {
    if (vote > 8) {
      return "tag--green";
    }
    if (vote >= 6) {
      return "tag--orange";
    }
    return "tag--red";
  }
  return (
    <div className="movie">
      <img
        src={
          poster_path != null
            ? IMG_API + poster_path
            : "https://image.winudf.com/v2/image/Y29tLm1ldy5taW90YWthbWl5YV9zY3JlZW5fMV8xNTIzMzM3Mjk1XzAxMw/screen-1.jpg?fakeurl=1&type=.jpg"
        }
        alt={title}
      />
      <div className="movie-info">
        <h3>{title}</h3>
        <span className={`tag ${setVoteClass(vote_average)}`}>
          {vote_average}
        </span>
      </div>

      <div className="movie-overview">
        <h2>Overview</h2>
        <p>{overview}</p>
      </div>
    </div>
  );
}
