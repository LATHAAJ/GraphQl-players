---
id: create-match
title: createMatch
---









No description


```graphql
createMatch(
  opponent: String!
  matchDate: String!
  venue: String!
  result: MatchResult!
): Match
```




### Arguments

#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">createMatch</code>.<code class="gqlmd-mdx-entity-name">opponent</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String!</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">createMatch</code>.<code class="gqlmd-mdx-entity-name">matchDate</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String!</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">createMatch</code>.<code class="gqlmd-mdx-entity-name">venue</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String!</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">createMatch</code>.<code class="gqlmd-mdx-entity-name">result</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">MatchResult!</code></span>](/types/enums/match-result) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">enum</mark> 



### Type

#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">Match</code></span>](/types/objects/match) <mark class="gqlmd-mdx-badge">object</mark>