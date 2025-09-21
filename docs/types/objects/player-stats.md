---
id: player-stats
title: PlayerStats
---









No description


```graphql
type PlayerStats {
  playerId: ID!
  matchesPlayed: Int
  runs: Int
  wickets: Int
  average: Float
}
```




### Fields

#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">PlayerStats</code>.<code class="gqlmd-mdx-entity-name">playerId</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">ID!</code></span>](/types/scalars/id) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">PlayerStats</code>.<code class="gqlmd-mdx-entity-name">matchesPlayed</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">Int</code></span>](/types/scalars/int) <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">PlayerStats</code>.<code class="gqlmd-mdx-entity-name">runs</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">Int</code></span>](/types/scalars/int) <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">PlayerStats</code>.<code class="gqlmd-mdx-entity-name">wickets</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">Int</code></span>](/types/scalars/int) <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">PlayerStats</code>.<code class="gqlmd-mdx-entity-name">average</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">Float</code></span>](/types/scalars/float) <mark class="gqlmd-mdx-badge">scalar</mark> 







### Returned By

[`findPlayerStats`](/operations/queries/find-player-stats)  <mark class="gqlmd-mdx-badge">query</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`updatePlayerStats`](/operations/mutations/update-player-stats)  <mark class="gqlmd-mdx-badge">mutation</mark>

### Member Of

[`Player`](/types/objects/player)  <mark class="gqlmd-mdx-badge">object</mark>