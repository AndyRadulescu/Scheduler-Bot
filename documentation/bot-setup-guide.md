<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">

<body>
<article class="markdown-body">

# Bot Setup Guide

## Resources needed:

#### Localtunnel
**Localtunnel allows you to easily share a web service on your local development machine without messing with DNS and firewall settings.**

To install localtunnel (javascript tool) execute the following command:

  * `npm install -g localtunnel`

## Steps:


### Facebook-Dev side:
1. Make sure you have a facebook page and a facebook app created.

  * [Create a facbook page](https://www.facebook.com/pages/create)

  * [Create a facebook app](https://developers.facebook.com/docs/apps/register)

2. Follow this link and do step 1 and 3:

  * [App Setup](https://developers.facebook.com/docs/messenger-platform/getting-started/app-setup)

  * Remember to save the  `PAGE_ACCESS_TOKEN`.

3. Go to your **app->settings->basic** and save the `APP_SECRET`.

### Server-side:
1. In the CallbackHandler class, edit the following variables to match your app settings:

  * `private static final String PAGE_ACCESS_TOKEN;`
  * `private static final String APP_SECRET;`

2. Run BotHandlerApplication.java on the desired port (default is **8080**)

3. Share the local web service using localtunnel by executing the following command:

  * `lt --port 8000`

4. Copy the generated URL to the clipboard.

### Final Steps
1. Go to your facebook **app->dashboard->webhooks** and click the edit subscription button.

2. In the Callback URL paste the URL generated by localtunnel and append __/webhook__ to it. (<URL>/webhook)

3. In the Verify Token textfield use the following default value **TOKEN**

4. If there are no errors, go to messenger and your bot should be responding.


# Documentation

# H1
## H2
### H3
#### H4
##### H5
###### H6

Alternatively, for H1 and H2, an underline-ish style:

Alt-H1
======

Alt-H2
------

Emphasis, aka italics, with *asterisks* or _underscores_.

Strong emphasis, aka bold, with **asterisks** or __underscores__.

Combined emphasis with **asterisks and _underscores_**.

Strikethrough uses two tildes. ~~Scratch this.~~

1. First ordered list item
2. Another item
⋅⋅* Unordered sub-list.
1. Actual numbers don't matter, just that it's a number
⋅⋅1. Ordered sub-list
4. And another item.

⋅⋅⋅You can have properly indented paragraphs within list items. Notice the blank line above, and the leading spaces (at least one, but we'll use three here to also align the raw Markdown).

⋅⋅⋅To have a line break without a paragraph, you will need to use two trailing spaces.⋅⋅
⋅⋅⋅Note that this line is separate, but within the same paragraph.⋅⋅
⋅⋅⋅(This is contrary to the typical GFM line break behaviour, where trailing spaces are not required.)

* Unordered list can use asterisks
- Or minuses
+ Or pluses

[I'm an inline-style link](https://www.google.com)

[I'm an inline-style link with title](https://www.google.com "Google's Homepage")

[I'm a reference-style link][Arbitrary case-insensitive reference text]

[I'm a relative reference to a repository file](../blob/master/LICENSE)

[You can use numbers for reference-style link definitions][1]

Or leave it empty and use the [link text itself].

URLs and URLs in angle brackets will automatically get turned into links.
http://www.example.com or <http://www.example.com> and sometimes
example.com (but not on Github, for example).

Some text to show that the reference links can follow later.

[arbitrary case-insensitive reference text]: https://www.mozilla.org
[1]: http://slashdot.org
[link text itself]: http://www.reddit.com

Colons can be used to align columns.

| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |

There must be at least 3 dashes separating each header cell.
The outer pipes (|) are optional, and you don't need to make the
raw Markdown line up prettily. You can also use inline Markdown.

Markdown | Less | Pretty
--- | --- | ---
*Still* | `renders` | **nicely**
1 | 2 | 3

</article>
</body>
</html>