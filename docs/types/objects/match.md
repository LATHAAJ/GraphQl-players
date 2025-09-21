---
id: match
title: Match
---









No description


```graphql
type Match {
  id: ID!
  opponent: String!
  matchDate: String!
  venue: String!
  result: MatchResult!
}
```




### Fields

#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">Match</code>.<code class="gqlmd-mdx-entity-name">id</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">ID!</code></span>](/types/scalars/id) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">Match</code>.<code class="gqlmd-mdx-entity-name">opponent</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String!</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">Match</code>.<code class="gqlmd-mdx-entity-name">matchDate</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String!</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">Match</code>.<code class="gqlmd-mdx-entity-name">venue</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">String!</code></span>](/types/scalars/string) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">scalar</mark> 



#### [<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-parent">Match</code>.<code class="gqlmd-mdx-entity-name">result</code></span>](#)<span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[<span class="gqlmd-mdx-entity"><code class="gqlmd-mdx-entity-name">MatchResult!</code></span>](/types/enums/match-result) <mark class="gqlmd-mdx-badge">non-null</mark> <mark class="gqlmd-mdx-badge">enum</mark> 







### Returned By

[`createMatch`](/operations/mutations/create-match)  <mark class="gqlmd-mdx-badge">mutation</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`findAllMatches`](/operations/queries/find-all-matches)  <mark class="gqlmd-mdx-badge">query</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`findMatchById`](/operations/queries/find-match-by-id)  <mark class="gqlmd-mdx-badge">query</mark>