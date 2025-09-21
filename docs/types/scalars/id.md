---
id: id
title: ID
---









The `ID` scalar type represents a unique identifier, often used to refetch an object or as key for a cache. The ID type appears in a JSON response as a String; however, it is not intended to be human-readable. When expected as an input type, any string (such as `"4"`) or integer (such as `4`) input value will be accepted as an ID.


```graphql
scalar ID
```








### Member Of

[`deletePlayer`](/operations/mutations/delete-player)  <mark class="gqlmd-mdx-badge">mutation</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`findMatchById`](/operations/queries/find-match-by-id)  <mark class="gqlmd-mdx-badge">query</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`findPlayerById`](/operations/queries/find-player-by-id)  <mark class="gqlmd-mdx-badge">query</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`findPlayerStats`](/operations/queries/find-player-stats)  <mark class="gqlmd-mdx-badge">query</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`Match`](/types/objects/match)  <mark class="gqlmd-mdx-badge">object</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`Player`](/types/objects/player)  <mark class="gqlmd-mdx-badge">object</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`PlayerStats`](/types/objects/player-stats)  <mark class="gqlmd-mdx-badge">object</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`updatePlayer`](/operations/mutations/update-player)  <mark class="gqlmd-mdx-badge">mutation</mark><span class="gqlmd-mdx-bullet">&nbsp;●&nbsp;</span>[`updatePlayerStats`](/operations/mutations/update-player-stats)  <mark class="gqlmd-mdx-badge">mutation</mark>