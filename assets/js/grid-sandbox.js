window.onload = function () {

  function getEventElement(mouseEvent) {
    let event = mouseEvent || window.event;
    return event.target || event.srcElement;
  }

  const sourceIdAttr = "sourceId";
  const referenceIdAttr = "referenceId";
  const originIdAttr = "originId";
  const originReferenceIdAttr = "originReferenceId";

  const referenceHighlightClass = "reference-highlight";
  const sourceHighlightClass = "source-highlight";

  function getReferenceElementsForId(sourceId, refIdAttr) {
    return document.querySelectorAll(`[${refIdAttr}="${sourceId}"]`);
  }

  function getReferenceElements(element, attr, refIdAttr) {
    let id = element.getAttribute(attr)
    return getReferenceElementsForId(id, refIdAttr);
  }

  function getSourceElement(element, srcIdAttr, refIdAttr) {
    let referenceId = element.getAttribute(refIdAttr)
    return document.querySelector(`[${srcIdAttr}="${referenceId}"]`);
  }

  function addClass(element, aClass) {
    element.classList.add(aClass)
  }

  function removeClass(element, aClass) {
    element.classList.remove(aClass)
  }

  function addClasses(elements, aClass) {
    for (const element of elements) {
      addClass(element, aClass);
    }
  }

  function removeClasses(elements, aClass) {
    for (const element of elements) {
      removeClass(element, aClass);
    }
  }

  function addReferenceClasses(element, attr, refIdAttr, highlightClass) {
    if (element.hasAttribute(attr)) {
      let referenceElements = getReferenceElements(element, attr, refIdAttr);
      addClasses(referenceElements, highlightClass);
    }
  }

  function removeReferenceClasses(element, attr, refIdAttr, highlightClass) {
    if (element.hasAttribute(attr)) {
      let referenceElements = getReferenceElements(element, attr, refIdAttr);
      removeClasses(referenceElements, highlightClass);
    }
  }

  function addClasses2(element, srcIdAttr, refIdAttr, highlightClass, srcHighlightClass) {
    addReferenceClasses(element, srcIdAttr, refIdAttr, highlightClass);
    addReferenceClasses(element, refIdAttr, refIdAttr, highlightClass);
    if (element.hasAttribute(refIdAttr)) {
      let sourceElement = getSourceElement(element, srcIdAttr, refIdAttr);
      addClass(sourceElement, srcHighlightClass);
    }
  }

  function removeClasses2(element, srcIdAttr, refIdAttr, highlightClass, srcHighlightClass) {
    removeReferenceClasses(element, srcIdAttr, refIdAttr, highlightClass);
    removeReferenceClasses(element, refIdAttr, refIdAttr, highlightClass);
    if (element.hasAttribute(refIdAttr)) {
      let sourceElement = getSourceElement(element, srcIdAttr, refIdAttr);
      removeClass(sourceElement, srcHighlightClass);
    }
  }

  document.onmouseover = function (event) {
    let element = getEventElement(event);
    addClasses2(element, sourceIdAttr, referenceIdAttr, referenceHighlightClass, sourceHighlightClass);
    addClasses2(element, originIdAttr, originReferenceIdAttr, referenceHighlightClass, sourceHighlightClass);
  };

  document.onmouseout = function (event) {
    let element = getEventElement(event);
    removeClasses2(element, sourceIdAttr, referenceIdAttr, referenceHighlightClass, sourceHighlightClass);
    removeClasses2(element, originIdAttr, originReferenceIdAttr, referenceHighlightClass, sourceHighlightClass);
  };

}
