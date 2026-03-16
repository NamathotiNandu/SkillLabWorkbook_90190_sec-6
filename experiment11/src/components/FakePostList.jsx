import React,{useState,useEffect} from "react";
import axios from "axios";

function FakePostList(){

  const [posts,setPosts] = useState([]);
  const [filtered,setFiltered] = useState([]);

  const fetchPosts = () => {

    axios.get("https://dummyjson.com/posts")
    .then(res=>{
        setPosts(res.data.posts);
        setFiltered(res.data.posts);
    });

  };

  useEffect(()=>{
    fetchPosts();
  },[]);

  const filterPosts = (e) => {

    const id = e.target.value;

    if(id==="all") setFiltered(posts);

    else setFiltered(posts.filter(p => p.userId == id));

  };

  return(

    <div>

      <h2>Fake API Posts</h2>

      <button onClick={fetchPosts}>Refresh</button>

      <br/><br/>

      <select onChange={filterPosts}>
        <option value="all">All</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
      </select>

      <ul>

        {filtered.map(p=>(
          <li key={p.id}>
            <b>{p.title}</b><br/>
            {p.body}
          </li>
        ))}

      </ul>

    </div>

  );

}

export default FakePostList;