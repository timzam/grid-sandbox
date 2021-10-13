window.onload = function () {

  function getEventElement(mouseEvent) {
    let event = mouseEvent || window.event;
    return event.target || event.srcElement;
  }

  const sourceIdAttr = "sourceId";
  const referenceIdAttr = "referenceId";

  const referenceHighlightClass = "reference-highlight";
  const sourceHighlightClass = "source-highlight";

  function getReferenceElementsForId(sourceId) {
    return document.querySelectorAll(`[${referenceIdAttr}=${sourceId}]`);
  }

  function getReferenceElements(element, attr) {
    let id = element.getAttribute(attr)
    return getReferenceElementsForId(id);
  }

  function getSourceElement(element) {
    let referenceId = element.getAttribute(referenceIdAttr)
    return document.querySelector(`[${sourceIdAttr}=${referenceId}]`);
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

  function addReferenceClasses(element, attr) {
    if (element.hasAttribute(attr)) {
      let referenceElements = getReferenceElements(element, attr);
      addClasses(referenceElements, referenceHighlightClass);
    }
  }

  function removeReferenceClasses(element, attr) {
    if (element.hasAttribute(attr)) {
      let referenceElements = getReferenceElements(element, attr);
      removeClasses(referenceElements, referenceHighlightClass);
    }
  }

  document.onmouseover = function (event) {
    var element = getEventElement(event);
    addReferenceClasses(element, sourceIdAttr);
    addReferenceClasses(element, referenceIdAttr);
    if (element.hasAttribute(referenceIdAttr)) {
      let sourceElement = getSourceElement(element);
      addClass(sourceElement, sourceHighlightClass);
    }
  };

  document.onmouseout = function (event) {
    var element = getEventElement(event);
    removeReferenceClasses(element, sourceIdAttr);
    removeReferenceClasses(element, referenceIdAttr);
    if (element.hasAttribute(referenceIdAttr)) {
      let sourceElement = getSourceElement(element);
      removeClass(sourceElement, sourceHighlightClass);
    }
  };

}
