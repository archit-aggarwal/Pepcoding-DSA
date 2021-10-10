public static int size(Node root) {
  if (root == null) return 0;

  int count = 1;
  for (Node child : root.children) {
    count += size(child);
  }

  return count;
}

public static int max(Node root) {
  int maximum = root.data;
  for (Node child : root.children) {
    maximum = Math.max(maximum, max(child));
  }

  return maximum;
}

public static int heightByNodes(Node root) {
  // in terms of nodes
  int height = 0;

  for (Node child : root.children) {
    height = Math.max(height, heightByNodes(child));
  }

  return height + 1;
}

public static int heightByEdges(Node root) {
  // in terms of edges

  int ans = 0;

  for (Node child : root.children) {
    ans = Math.max(ans, heightByEdges(child) + 1);
  }

  return ans;
}


public static int height(Node root) {
  // in terms of edges

  // return heightByEdges(root);

  if (root == null) return 0;

  int ans = heightByNodes(root);
  return ans - 1;

}
