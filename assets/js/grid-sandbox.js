window.onload = function () {

  function getEventElement(e) {
    let event = e || window.event;
    let el = event.target || el.srcElement;
    return el;
  }

  function hasSourceIdAttr(el) {
    return el.hasAttribute("sourceId");
  }

  document.onmouseover = function (e) {
    var el = getEventElement(e);
    if (hasSourceIdAttr(el)) {
      mouseOverSourceId(el)
    }
  };

  document.onmouseout = function (e) {
    var el = getEventElement(e);
    if (hasSourceIdAttr(el)) {
      mouseOutSourceId(el)
    }
  };

  function getReferenceElements(e) {
    let sourceId = e.getAttribute('sourceId')
    return document.querySelectorAll(`[referenceId=${sourceId}]`);
  }

  const referenceHighlight = "reference-highlight";

  function mouseOverSourceId(e) {
    let elements = getReferenceElements(e);
    for (const element of elements) {
      element.classList.add(referenceHighlight)
    }
  }

  function mouseOutSourceId(e) {
    let elements = getReferenceElements(e);
    for (const element of elements) {
      element.classList.remove(referenceHighlight)
    }
  }

}
