---
id: update-player
title: updatePlayer
---









No description


```graphql
updatePlayer(
  id: ID!
  name: String
  team: Team
  role: PlayerRole
  age: Int
  dateOfBirth: String
  country: String
): Player
```




### Arguments

#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">updatePlayer</code>.<code class="gqlmd-mdx-entity-name">id</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">ID!</code></span>](/types/scalars/id) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">updatePlayer</code>.<code class="gqlmd-mdx-entity-name">name</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">updatePlayer</code>.<code class="gqlmd-mdx-entity-name">team</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">Team</code></span>](/types/enums/team) <mark class="gqlmd-mdx-badge">enum</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">updatePlayer</code>.<code class="gqlmd-mdx-entity-name">role</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">PlayerRole</code></span>](/types/enums/player-role) <mark class="gqlmd-mdx-badge">enum</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">updatePlayer</code>.<code class="gqlmd-mdx-entity-name">age</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">Int</code></span>](/types/scalars/int) <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">updatePlayer</code>.<code class="gqlmd-mdx-entity-name">dateOfBirth</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">updatePlayer</code>.<code class="gqlmd-mdx-entity-name">country</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">scalar</mark> 



### Type

#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">Player</code></span>](/types/objects/player) <mark class="gqlmd-mdx-badge">object</mark>